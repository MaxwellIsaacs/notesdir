#!/bin/bash

# Request current path of the screenshot
read -p "Enter the current path of the screenshot: " screenshot_path

# Check if the file exists
if [[ ! -f $screenshot_path ]]; then
    echo "File does not exist. Please check the path and try again."
    exit 1
fi

# List directories in /home/max/school
school_dir="/home/max/school"
echo "Available directories in $school_dir:"
dirs=($(ls -d $school_dir/*/))  # Get all directories

# Display directories
for i in "${!dirs[@]}"; do
    echo "$i) ${dirs[$i]}"
done

# Request the directory choice
read -p "Enter the number of the directory to move the screenshot to: " dir_index

# Validate the input
if [[ $dir_index -ge 0 && $dir_index -lt ${#dirs[@]} ]]; then
    target_dir="${dirs[$dir_index]}"
else
    echo "Invalid selection. Exiting."
    exit 1
fi

# Move the screenshot
mv "$screenshot_path" "$target_dir"

# Print the new location in Org mode format
if [[ $? -eq 0 ]]; then
    new_path="${target_dir}$(basename "$screenshot_path")"
    echo "Screenshot successfully moved."
    echo "Org mode link to use: [[file:$new_path]]"
else
    echo "Failed to move the screenshot."
fi
