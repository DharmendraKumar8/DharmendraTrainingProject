package com.example.demo.domain;

import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Security {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	private int attempts;
	private Date blockedLoginTime;
	private Date blockedTradeTime;
	private String clientSessionId;
	private String googleAuthKey;
	private boolean isEmailVerified;
	private boolean isMobileVerified;
	private boolean isUserBlocked;
	private boolean isUserTradeBlocked;
	private String password;
	private int otp;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	private Long userId;
	private String email;
	private String confirmationToken;

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getBlockedLoginTime() {
		return blockedLoginTime;
	}

	public void setBlockedLoginTime(Date blockedLoginTime) {
		this.blockedLoginTime = blockedLoginTime;
	}

	public Date getBlockedTradeTime() {
		return blockedTradeTime;
	}

	public void setBlockedTradeTime(Date blockedTradeTime) {
		this.blockedTradeTime = blockedTradeTime;
	}

	public String getClientSessionId() {
		return clientSessionId;
	}

	public void setClientSessionId(String clientSessionId) {
		this.clientSessionId = clientSessionId;
	}

	public String getGoogleAuthKey() {
		return googleAuthKey;
	}

	public void setGoogleAuthKey(String googleAuthKey) {
		this.googleAuthKey = googleAuthKey;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public boolean isMobileVerified() {
		return isMobileVerified;
	}

	public void setMobileVerified(boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public boolean isUserBlocked() {
		return isUserBlocked;
	}

	public void setUserBlocked(boolean isUserBlocked) {
		this.isUserBlocked = isUserBlocked;
	}

	public boolean isUserTradeBlocked() {
		return isUserTradeBlocked;
	}

	public void setUserTradeBlocked(boolean isUserTradeBlocked) {
		this.isUserTradeBlocked = isUserTradeBlocked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
}