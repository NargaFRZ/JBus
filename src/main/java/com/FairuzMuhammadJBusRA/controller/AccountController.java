package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.Account;
import com.FairuzMuhammadJBusRA.Algorithm;
import com.FairuzMuhammadJBusRA.Renter;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static @JsonAutowired(value = Account.class, filepath = "src/main/java/com/FairuzMuhammadJBusRA/json/Account.json")
    JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return AccountController.accountTable;
    }

    @GetMapping
    String index() {
        return "account page";
    }

    @PostMapping("/register")
    BaseResponse<Account> register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if (name.isBlank()) {
            return new BaseResponse<>(false, "Gagal register: Nama tidak boleh kosong", null);
        }

        Account account = new Account(name, email, password);
        if (!account.validate()) {
            return new BaseResponse<>(false, "Gagal register: Regex tidak sesuai", null);
        }

        if (Algorithm.<Account>exists(accountTable, a -> a.email.equals(account.email))) {
            return new BaseResponse<>(false, "Gagal register: Email telah terdaftar", null);
        }

        String hashedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        account.password = hashedPassword;
        accountTable.add(account);

        return new BaseResponse<>(true, "Berhasil register", account);
    }

    @PostMapping("/login")
    BaseResponse<Account> login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        String temp = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            temp = sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        String hashedPassword = temp;
        Account account = Algorithm.<Account>find(accountTable, a -> a.email.equals(email) && a.password.equals(hashedPassword));
        if(account!=null){
            return new BaseResponse<>(true, "Berhasil login", account);
        }
        else{
            return new BaseResponse<>(false, "Gagal login: Email atau Password salah", null);
        }
    }

    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter>registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String companyName,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        Account account = Algorithm.<Account>find(accountTable, a -> a.id == id);
        if(account == null){
            return new BaseResponse<>(false, "Gagal register: Akun tidak ditemukan", null);
        }

        if(account.company != null){
            return new BaseResponse<>(false, "Gagal register: Akun sudah terdaftar sebagai Renter", null);
        }

        Renter renter = new Renter(companyName, address, phoneNumber);
        if (!renter.validate()) {
            return new BaseResponse<>(false, "Gagal register: Regex tidak sesuai", null);
        }

        account.company = renter;

        return new BaseResponse<>(true, "Berhasil register Akun sebagai renter", renter);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Account>topUp
            (
                    @PathVariable int id,
                    @RequestParam double amount
            )
    {
        Account account = Algorithm.<Account>find(accountTable, a -> a.id == id);
        if(account == null){
            return new BaseResponse<>(false, "Gagal Top Up: Akun tidak ditemukan", null);
        }

        if(!account.topUp(amount)){
            return new BaseResponse<>(false, "Gagal Top Up: Jumlah tidak valid", null);
        }

        return new BaseResponse<>(true, "Top Up berhasil", account);
    }
}
