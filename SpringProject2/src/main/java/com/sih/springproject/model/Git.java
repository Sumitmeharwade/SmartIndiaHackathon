package com.sih.springproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public class Git extends Details {
    @OneToOne
    private Links links;
}
