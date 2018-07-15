package com.lrm;


import com.alibaba.fastjson.JSON;
import com.lrm.domain.Author;
import com.lrm.domain.AuthorRepository;
import com.lrm.domain.Wallet;
import com.lrm.domain.WalletRepository;
import com.lrm.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRTest {


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void saveAuthorTest(){
        Author author = new Author();
        author.setNickName("Arvin");
        author.setPhone("18237323232");
        author.setSignDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(22.33)));
        authorRepository.save(author);
    }


    @Test
    public void updateAuthor(){
        Author author = authorService.findAuthor(3l).get();
        author.setPhone("18373229089");
        Wallet wallet = author.getWallet();
        wallet.setBalance(new BigDecimal(123.44));
        author.setWallet(wallet);

        authorService.updateAuthor(author);
    }


    @Test
    public void findAuthor(){
        Author author = authorService.findAuthor(3l).get();
        System.out.println(JSON.toJSONString(author,true));
    }


    @Test
    public void deleteAuthor(){
        authorService.deleteAuthor(3l);
    }


    @Test
    public void findWallet(){
        Wallet wallet = walletRepository.findById(6l).get();
        System.out.println(JSON.toJSONString(wallet,true));
    }

}
