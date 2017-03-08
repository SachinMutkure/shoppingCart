package com.sam.demo.utility;

public class CandidateDetails {
	
	@MyCustomAnnotation(name="Gender")
	private String gender;

	@MyCustomAnnotation(name="Candidate Name")	
    private String candidateName;

	@MyCustomAnnotation(name="Father Name")
    private String fatherName;

	@MyCustomAnnotation(name="Mother Name")
    private String motherName;

	@MyCustomAnnotation(name="Mobile No.")
    private String mobileNumber;

	@MyCustomAnnotation(name="Email Id")
    private String emailid;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public CandidateDetails(String gender, String candidateName, String fatherName,
			String motherName, String mobileNumber, String emailid) {
		super();
		this.gender = gender;
		this.candidateName = candidateName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.mobileNumber = mobileNumber;
		this.emailid = emailid;
	}
   }
