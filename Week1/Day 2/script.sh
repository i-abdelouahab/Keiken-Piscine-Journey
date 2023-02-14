#!/bin/bash

if [ $# -eq 0 ]; then
  echo "Usage: $0 num_threads"
  exit 1
fi

num_threads=$1

for i in $(seq 1 $num_threads); do
  # Create a thread with a random priority between 1 and 10
  priority=$((RANDOM % 10 + 1))
  echo "Creating thread $i with priority $priority"
  ( echo "Hello from thread $i with PID $$ and priority $priority"; ) &
done

# Wait for all threads to finish
wait

echo "All threads have finished"