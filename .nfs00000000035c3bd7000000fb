#!/bin/bash

for algo in counting
do
        for test in $(ls ./exemplaires)
        do
				echo $algo " " $test
                ./tp.sh -a $algo -e ./exemplaires/$test -t
        done
done
