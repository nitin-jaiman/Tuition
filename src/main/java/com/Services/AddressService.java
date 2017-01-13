package com.Services;

import com.Modal.AddressEntity;
import com.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by apple on 03/01/17.
 */
@Service
public class AddressService  {

    @Autowired
    private AddressRepository addressRepository;




    public ArrayList<AddressEntity> getAddressEntities(){


        ArrayList<AddressEntity> addressEntityList = loadAddressEntities();



        return addressEntityList;


    }


    public AddressEntity addAddress(AddressEntity addressEntity){


        AddressEntity uEntity=addressRepository.save(addressEntity);

     /*   AuthEntity authEntity=new AuthEntity();
        authEntity.setAddressEntity(uEntity);
        authEntity.setAuthIsValid((byte) 1);
        authEntity.setAuthKey(GenerateRandomString.getRandomString());


       AuthEntity aEntity= authRepository.save(authEntity);
       */

        return uEntity;

    }



    public AddressEntity updateAddress(AddressEntity addressEntity){


        return addressRepository.save(addressEntity);

    }

    public void deleteAddress(AddressEntity addressEntity){

        addressRepository.delete(addressEntity);

    }

    public AddressEntity getAddressById(Integer addressId){


        return addressRepository.findOne(addressId);


    }


    private ArrayList<AddressEntity> loadAddressEntities() {
        ArrayList<AddressEntity> addressEntityList=new ArrayList<AddressEntity>();

        Iterator<AddressEntity> iterable=addressRepository.findAll().iterator();

        while(iterable.hasNext()){


            addressEntityList.add(iterable.next());

        }
        return addressEntityList;
    }




}
