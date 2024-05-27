/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.romomo.entity.Ordine;

public class OrdineDAO implements Interface<Ordine> {
	
	private Manager manager;
	
	private List<Ordine> ordini;
    
    @Override
    public List<Ordine> fetchAll() throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'fetchAll'");
    }

    @Override
    public void save(Ordine entity) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    public OrdineDAO() {
        manager = Manager.getInstance();
        ordini = new ArrayList<>();
    }

}
