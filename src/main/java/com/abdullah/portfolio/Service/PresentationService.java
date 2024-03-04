package com.abdullah.portfolio.Service;

import com.abdullah.portfolio.Dao.PresentationDao;
import com.abdullah.portfolio.Model.PresentationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationService {

    @Autowired
    private PresentationDao presentationDao;


    public void addPresentation(PresentationEntity presentation)
    {
        presentationDao.createPresentation(presentation);
    }


    public PresentationEntity getSinglePresentation(int presentation_id)
    {
        return presentationDao.readById(presentation_id);
    }

}
