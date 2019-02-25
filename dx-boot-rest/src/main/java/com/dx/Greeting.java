package com.dx;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-25
 */

@XmlRootElement(name="root")
public class Greeting {

    private  long id;

    private  String name;

    public Greeting() {

    }

    public Greeting(long id,String name) {
        this.id = id;

        this.name =name;
    }

    public long getId() {
        return id;
    }


    @XmlElement(name="ID")
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name="MyName")
    public void setName(String name) {
        this.name = name;
    }


}
