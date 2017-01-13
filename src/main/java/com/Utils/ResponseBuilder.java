package com.Utils;

import java.util.ArrayList;

/**
 * Created by apple on 28/12/16.
 */
public class ResponseBuilder {

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ArrayList<Links> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Links> links) {
        this.links = links;
    }

    private ArrayList<Links> links;


}
