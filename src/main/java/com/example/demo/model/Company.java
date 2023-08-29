package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Company {
	
		@Id
		private int compid;
		
		private String compname;
		
		private String compemail;

		public int getCompid() {
			return compid;
		}

		public void setCompid(int compid) {
			this.compid = compid;
		}

		public String getCompname() {
			return compname;
		}

		public void setCompname(String compname) {
			this.compname = compname;
		}

		public String getCompemail() {
			return compemail;
		}

		public void setCompemail(String compemail) {
			this.compemail = compemail;
		}
	}


