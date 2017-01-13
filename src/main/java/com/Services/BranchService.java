package com.Services;

import com.Modal.BranchEntity;
import com.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 31/12/16.
 */
@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;



    public List<BranchEntity> getBranches(Integer instituteId){


        List<BranchEntity> branchEntityList=new ArrayList<BranchEntity>();

        Iterator<BranchEntity> iterable=branchRepository.findByInstituteEntityInstituteId(instituteId).iterator();

        while(iterable.hasNext()){

            branchEntityList.add(iterable.next());

        }

        return branchEntityList;


    }

    public BranchEntity getBranchById(Integer branchId){


        return branchRepository.findOne(branchId);

    }


    public BranchEntity addBranch(BranchEntity branchEntity){





        return branchRepository.save(branchEntity);


    }

    public BranchEntity updateBranch(BranchEntity branchEntity){





        return branchRepository.save(branchEntity);


    }

    public void deleteBranch(BranchEntity branchEntity){





        branchRepository.delete(branchEntity);


    }


}
