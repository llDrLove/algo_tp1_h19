#!/bin/bash

for algo in quick quickSeuil quickRandomSeuil
do
        for test in $(ls ./exemplaires)
        do
                ./tp.sh -a $algo -e ./exemplaires/$test -t >> ./results/"$algo"_results.txt
        done
done
