package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.Account;
import com.FairuzMuhammadJBusRA.Algorithm;
import com.FairuzMuhammadJBusRA.dbjson.JsonAutowired;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "java/com/Account.json")
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
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
            ) throws NoSuchAlgorithmException {
        if (name.isBlank()) {
            return new BaseResponse<>(false, "Gagal register", null);
        }

        Account temp = new Account(name, email, password);
        if (!temp.validate()) {
            return new BaseResponse<>(false, "Gagal register", null);
        }

        if (Algorithm.<Account>exists(accountTable, account -> account.email.equals(temp.email))) {
            return new BaseResponse<>(false, "Gagal register", null);
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hashedPassword = sb.toString();

        Account account = new Account(name, email, hashedPassword);
        accountTable.add(account);

        return new BaseResponse<>(true, "Berhasil register", account);
    }

    @PostMapping("/login")
    BaseResponse<Account> login
            (
                    @RequestParam String email,
                    @RequestParam String password
            ){
        return null;
    }
}
