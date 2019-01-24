#!/bin/bash

if [ -z "$2" ]
	then
		echo "You must provide an algorithm. (Ex: counting | quick | quickSeuil | quickRandomSeuil)"
		exit
fi

if [ -z "$4" ]
	then
		echo "You must provide a path. (Ex: ./exemplaires/testset_1000_0.txt)"
		exit
fi

java TP1 -a $2 -e $4 $5 $6
