/**
 * 
 */
package com.ex02.c4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.c4.dto.Proyecto;

/**
 * @author elena-01
 *
 */
public interface IProyectoDAO extends JpaRepository<Proyecto, String> {

}
