package com.Controller;

import com.Modal.AddressEntity;
import com.Services.AuthService;
import com.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by apple on 03/01/17.
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;





    /*
    get all addresss
     */
    @RequestMapping(method = {RequestMethod.GET})
    private ArrayList<AddressEntity> getAddresss(){


        ArrayList<AddressEntity> addressEntities=addressService.getAddressEntities();
        if(addressEntities.size()>0){

            for(AddressEntity addressEntity:addressEntities){

              //  addressEntity.add(linkTo(AddressController.class).slash(addressEntity.getAddressId()).slash("institutes").withRel("institutes"));


            }

        }


        return addressService.getAddressEntities();
    }


    /**
     * get address by addressId
     * @param addressId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET},value = "/{addressId}")
    private AddressEntity getAddressById(@PathVariable Integer addressId){

        AddressEntity addressEntity=   addressService.getAddressById(addressId);
       // addressEntity.add(linkTo(AddressController.class).slash(addressId).slash("institutes").withRel("institutes"));

        return addressEntity;
    }



    @RequestMapping(method = {RequestMethod.POST})
    private AddressEntity saveAddress(@RequestBody AddressEntity addressEntity){



        AddressEntity uEntity=addressService.addAddress(addressEntity);
       // uEntity.add(linkTo(AddressController.class).withSelfRel());
        //uEntity.add(linkTo(AddressController.class).slash("getcourses").withRel("courses"));


        return uEntity;


    }




    @RequestMapping(method = {RequestMethod.PUT})
    private AddressEntity updateAddress(@RequestBody AddressEntity addressEntity,HttpServletResponse response){


        AddressEntity uEntity = addressService.updateAddress(addressEntity);
       // uEntity.add(linkTo(AddressController.class).withSelfRel());
       // uEntity.add(linkTo(AddressController.class).slash("getcourses").withRel("courses"));

        return uEntity;


    }






    @RequestMapping(method = {RequestMethod.DELETE})
    private void deleteAddress(@RequestBody AddressEntity addressEntity, HttpServletResponse response){





        addressService.deleteAddress(addressEntity);


        response.addHeader("success","true");

    }


}
