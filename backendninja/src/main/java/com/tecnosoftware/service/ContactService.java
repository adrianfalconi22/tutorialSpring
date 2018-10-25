package com.tecnosoftware.service;

import java.util.List;

import com.tecnosoftware.entity.Contact;
import com.tecnosoftware.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);

	public abstract List<ContactModel> listAllContacts();

	public abstract Contact findContactById(int id);

	public abstract void removeContact(int id);

	public ContactModel findContactByIdModel(int id);
}
