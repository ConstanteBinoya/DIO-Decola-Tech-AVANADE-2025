package me.dio.d_t_avanade_2025.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String number;

	private String agency;

	@Column( precision = 13, scale = 2)
	private BigDecimal balance;

	@Column(precision = 13, scale = 2)
	private BigDecimal creditLimit;

	@OneToOne(mappedBy = "account")
	private User user;

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getLimit() {
		return creditLimit;
	}

	public void setLimit(BigDecimal limit) {
		this.creditLimit = limit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
