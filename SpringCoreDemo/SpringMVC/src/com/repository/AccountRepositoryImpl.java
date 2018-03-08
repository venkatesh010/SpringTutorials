package com.repository;

import com.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
    public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> fetchAll(){
        String selectSQL = "select * from spring.account";
        List<Account> accountList = jdbcTemplate.query(selectSQL, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        });

        return accountList;
    }

    @Override
    public void save(Account account){
        String insertSQL = "insert into account(id,name,balance) values(?,?,?)";
        int rowsAffected = jdbcTemplate.update(insertSQL, account.getId(), account.getName(), account.getBalance());

        System.out.println("AccountRepositoryImpl.saved: "+rowsAffected);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deposit(int id, double amount) throws Exception {

        String updateSQL = "Update spring.account set balance = balance+ ? where id = ? ";
        int rowsAffected = jdbcTemplate.update(updateSQL, amount, id);

        if(rowsAffected != 1){
            throw new Exception("Deposit Failed");
        }

        System.out.println("AccountRepositoryImpl.saved: "+rowsAffected);

    };
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw(int id, double amount) throws Exception {

        String updateSQL = "Update spring.account set balance = balance- ? where id = ? and balance > ? ";
        int rowsAffected = jdbcTemplate.update(updateSQL, amount, id, amount);

        if(rowsAffected != 1){
            throw new Exception("Deposit Failed");
        }

        System.out.println("AccountRepositoryImpl.saved: "+rowsAffected);

    };
}
