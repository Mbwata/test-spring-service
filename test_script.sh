for i in {1..300}; do echo $(curl localhost:9500/claimnumber/) >> log.txt; done