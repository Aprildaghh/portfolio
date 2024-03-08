package com.abdullah.portfolio.exiviluxi.Service;

import com.abdullah.portfolio.exiviluxi.Dao.PresentationDao;
import com.abdullah.portfolio.exiviluxi.Model.PresentationEntity;
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
