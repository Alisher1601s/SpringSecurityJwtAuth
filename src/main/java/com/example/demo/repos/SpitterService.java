package com.example.demo.repos;
import java.util.List;
public interface SpitterService {
List<Integer>getNewArray(int size);
void addInteger(Integer number);
Integer getNumber(int id);
void deletNumber(int id);
}
