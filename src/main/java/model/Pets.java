/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 24, 2023
 */
package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pets {
	@Id
	@GeneratedValue
	private int petId;
	private String name;
	private LocalDate birthday;
	private float weight;
	private String gender;
	/**
	 * 
	 */
	public Pets() {
		super();
	}
	/**
	 * @param name
	 * @param birthday
	 * @param weight
	 * @param gender
	 */
	public Pets(String name, LocalDate birthday, float weight, String gender) {
		super();
		setName(name);
		setBirthday(birthday);
		setWeight(weight);
		setGender(gender);
	}
	/**
	 * @return the petId
	 */
	public int getPetId() {
		return petId;
	}
	/**
	 * @param petId the petId to set
	 */
	public void setPetId(int petId) {
		this.petId = petId;
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
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", birthday=" + birthday + ", weight=" + weight + ", gender="
				+ gender + "]";
	}
	
	
}
