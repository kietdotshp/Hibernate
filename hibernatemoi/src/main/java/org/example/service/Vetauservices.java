package org.example.service;

import java.util.List;

import org.example.entity.Vetau;

public interface Vetauservices {
	List<Vetau> findAll(Vetau vetau);
	public boolean CreateVetau(Vetau vetau);
	public boolean Update(Vetau vetau);
	public boolean Delete(Vetau vetau);
	public Vetau findbyIdVe(int veId);
}
