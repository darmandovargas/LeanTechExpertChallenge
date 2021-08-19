package com.leantech.expert.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="position")
public class Position{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 7815042964764592917L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@JsonManagedReference	
	@OneToMany(mappedBy="position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	private Set<Employee> employees;
	/**
	 * 
	 */
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 */
	public Position(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
