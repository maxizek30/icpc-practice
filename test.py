#!/usr/bin/env python3

#
# This is a script that can be used to test an ICPC solution against the judge's data.  
# It assumes the following:
#     - the solution to be tested is written in Java
#     - you have a JDK installed and available in the PATH
#     - the Java solution has already been compiled and .class files are available
#     - the input and answer files are located in the same directory
#     - the input files are named *.in
#     - the answer files are named *.ans
# 
# To use:
#     1.  Make sure to compile your solution first.
#     2.  Edit the configuration settings below to match your setup.
#         Note that the paths are relative to the directory in which you launch this script.
#     3.  Run the script with the following command:
#             python3 test.py
#

from pathlib import Path
import sys, subprocess, math, difflib

##### Configuration ################################################

# Directory containing judge's input/answer data
data_dir = Path(".") / "2021" / "problem-y" / "secret_y"

# Directory containing compiled .class files
classpath = Path(".") / "2021" / "problem-y"

# Main class name
main_class = "y"

# How to compare the output: "string" or "float"
compare_type = "string"

# Precision to use when comparing using "float"
precision = 1e-5

# Show program output
show_output = False

###### End configuration ##########################################

def run_all( input_files ):
    count = 0; total = 0
    for f in input_files:
        # Execute and capture output
        output = run_java(main_class, f)

        # Read the answer file
        answer_file = f.with_suffix(".ans")
        expected = answer_file.read_text(encoding="utf-8").splitlines()

        # Compare
        if compare_type == "string":
            if compare_string(expected, output, f.name):
                count += 1
        elif compare_type == "float":
            if compare_float(expected, output, f.name):
                count += 1
        if show_output:
            print(output)
        total += 1

    print(f"Tests: {total} PASS: {count} FAIL: {total - count}")

def run_java( main_class, input_path ):
    with open(input_path) as f:
        result = subprocess.run(["java", "-cp", classpath, main_class],
                                capture_output=True,
                                stdin=f)
    if len(result.stderr) != 0:
        raise Exception(result.stderr.decode("utf-8"))

    return result.stdout.decode("utf-8").splitlines()

def compare_float(expected, actual, name):
    expected = float(expected[0])
    actual = float(actual[0])
    result = math.isclose(expected, actual, rel_tol=precision)
    if(result):
        print(f"{name} PASS")
    else:
        print(f"{name} FAIL expected: {expected} actual: {actual}")
    return result

def compare_string(expected, actual, name):
    if expected == actual:
        print(f"{name} PASS")
        return True

    # Add line endings because unified_diff expects them
    expected = [line + '\n' for line in expected]
    actual = [line + '\n' for line in actual]

    # Test failed, produce and display differences
    result = difflib.unified_diff(expected, actual, fromfile='expected',
                                  tofile="actual")
    print(f"{name} FAIL")
    print("".join(result))
    return False

print(f"Python version: {sys.version}")
# Get a list of input files in the directory
input_files = data_dir.glob("*.in")
run_all(input_files)