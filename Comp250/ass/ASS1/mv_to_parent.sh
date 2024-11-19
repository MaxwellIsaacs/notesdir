#!/bin/bash

# Check if a directory is passed as an argument
if [ -z "$1" ]; then
  echo "Usage: $0 <directory>"
  exit 1
fi

# Get the absolute path of the target directory
TARGET_DIR=$(realpath "$1")

# Get the parent directory
PARENT_DIR=$(dirname "$TARGET_DIR")

# Move all files from the target directory to its parent directory
mv "$TARGET_DIR"/* "$PARENT_DIR"

echo "Moved all files from $TARGET_DIR to $PARENT_DIR"
