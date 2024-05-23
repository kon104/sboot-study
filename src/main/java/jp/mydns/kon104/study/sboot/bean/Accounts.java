package jp.mydns.kon104.study.sboot.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Accounts {

	public Accounts() {}
	
	public Accounts(int uid, String name, String password) {
		this.uid = uid;
		this.name = name;
		this.password = password;
	}

	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

}
