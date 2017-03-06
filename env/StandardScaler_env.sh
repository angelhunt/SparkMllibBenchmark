#!/usr/bin/env bash
BENCHMARK_NAME="StandardScaler"
PACKAGE="skydata.spark.benchmark.others"
CLASS="${PACKAGE}.${BENCHMARK_NAME}Benchmark"

DIR=`dirname "$0"`
DIR=`cd "$DIR"/..; pwd`
DATA_DIR="${DIR}/data/$BENCHMARK_NAME"
OUTPUT_DIR="${DIR}/result"

#DATA_GEN_ARG=
N_POINTS="40"
N_CLUSTERS="5"
DIMENSTION="10"
SCALING="0.6"
NUMPAR="5"
DATA_GEN_ARG="${N_POINTS} ${N_CLUSTERS} ${DIMENSTION} ${SCALING} ${NUMPAR}"

#ALG_ARG=
WITH_MEAN="true"
WITH_STD="true"
ALG_ARG="${WITH_MEAN} ${WITH_STD}"
