/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.dao;

import java.sql.SQLException;
import java.util.Map;

public interface Interface<KeyType, Type> {
    
    Map<KeyType, Type> fetch() throws SQLException;

    void insert(Type entity) throws SQLException;

    void update(Type entity) throws SQLException;

    void delete(Type entity) throws SQLException;
}
