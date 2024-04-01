package com.example.demo.src.contact;

import com.example.demo.src.dto.ContactRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactService {
    private final ContactRepository contactRepository;

    @Transactional(readOnly = false)
    public void postContact(ContactRequestDto contactReq) {
        Contact contact = new Contact();
        contact.setName(contactReq.getName());
        contact.setEmail(contactReq.getEmail());
        contact.setPhone(contactReq.getPhone());
        contact.setMessage(contactReq.getMessage());
        contactRepository.save(contact);
    }
}
