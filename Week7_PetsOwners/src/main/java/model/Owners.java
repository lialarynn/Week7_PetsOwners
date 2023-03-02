/**
 * @author Lia Kruger - alkruger2
 * CIS175 - Spring 2023
 * Feb 25, 2023
 */
package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owners")
public class Owners {
	@Id
	@GeneratedValue
	private int ownerId;
	private String name;
	private LocalDate birthday;
	/**
	 * 
	 */
	public Owners() {
		super();
	}
	/**
	 * @param name
	 * @param birthday
	 */
	public Owners(String name, LocalDate birthday) {
		super();
		setName(name);
		setBirthday(birthday);
	}
	/**
	 * @return ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
	
}