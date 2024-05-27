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
import java.util.Map;

public interface Interface<KeyType, Type> {
    
    Map<KeyType, Type> fetchAll() throws SQLException;

    void save(Type entity) throws SQLException;

    void update(Type entity) throws SQLException;

    void delete(Type entity) throws SQLException;
}
