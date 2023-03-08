/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 24, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pets {
	@Id
	@GeneratedValue
	private int petId;
	private String name;
	private LocalDate birthday;
	private String species;
	private String breed;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Owners> listOfOwners;
	/**
	 * 
	 */
	public Pets() {
		super();
	}
	/**
	 * @param name
	 * @param birthday
	 * @param species
	 * @param breed
	 */
	public Pets(String name, LocalDate birthday, String species, String breed) {
		super();
		setName(name);
		setBirthday(birthday);
		setSpecies(species);
		setBreed(breed);
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
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	/**
	 * @return the listOfOwners
	 */
	public List<Owners> getListOfOwners() {
		return listOfOwners;
	}
	/**
	 * @param listOfOwners the listOfOwners to set
	 */
	public void setListOfOwners(List<Owners> listOfOwners) {
		this.listOfOwners = listOfOwners;
	}
	@Override
	public String toString() {
		return "Pets [petId=" + petId + ", name=" + name + ", birthday=" + birthday + ", species=" + species
				+ ", breed=" + breed + ", listOfOwners=" + listOfOwners + "]";
	}
	
}
