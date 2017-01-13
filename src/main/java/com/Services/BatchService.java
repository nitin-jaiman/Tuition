package com.Services;

import com.Modal.BatchEntity;
import com.Repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 03/01/17.
 */
@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;



    public List<BatchEntity> getBatches(Integer branchId){


        List<BatchEntity> batchEntityList=new ArrayList<BatchEntity>();

        Iterator<BatchEntity> iterable=batchRepository.findByBranchEntityBranchId(branchId).iterator();

        while(iterable.hasNext()){

            batchEntityList.add(iterable.next());

        }

        return batchEntityList;


    }

    public BatchEntity getBatchById(Integer batchId){


        return batchRepository.findOne(batchId);

    }


    public BatchEntity addBatch(BatchEntity batchEntity){





        return batchRepository.save(batchEntity);


    }

    public BatchEntity updateBatch(BatchEntity batchEntity){





        return batchRepository.save(batchEntity);


    }

    public void deleteBatch(BatchEntity batchEntity){





        batchRepository.delete(batchEntity);


    }




}
