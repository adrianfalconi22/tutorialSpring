package com.tecnosoftware.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecnosoftware.component.ContactConverter;
import com.tecnosoftware.entity.Contact;
import com.tecnosoftware.model.ContactModel;
import com.tecnosoftware.repository.ContactRepository;
import com.tecnosoftware.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact);
	}

	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;

	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);

	}

	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContactToContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (null != contact) {
			contactRepository.delete(contact);
		}
	}

}
