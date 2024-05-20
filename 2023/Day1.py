import re
import math

f = open(r'your file')
lines = f.read().splitlines()
f.close()

######################### PART 1 #########################

scorefinal = 0
for line in lines:
    score = 0
    lastnumber = 0
    number = 0
    for char in line:
        if char.isdigit() and score == 0:
            score = 1
            number = char
        elif char.isdigit() and score >= 1:
            lastnumber = char
            score += 1
    if score == 1:
        number = str(number) + str(number)
    else:
        number = str(number) + str(lastnumber)
    scorefinal += int(number)

print("Part1 : " + str(scorefinal))

######################### PART 2 #########################

new_lines = []
translate = {'zero': 'z0o', 'one': 'o1e', 'two': 't2o', 'three': 't3e', 'four': 'f4r', 'five': 'f5e', 'six': 's6x',
             'seven': 's7n', 'eight': 'e8t', 'nine': 'n9e'}
for line in lines:
    for key, value in translate.items():
            line = line.replace(key, value)
    new_lines.append(line)
print(new_lines)

scorefinal = 0
for line in new_lines:
    score = 0
    lastnumber = 0
    number = 0
    for char in line:
        if char.isdigit() and score == 0:
            score = 1
            number = char
        elif char.isdigit() and score >= 1:
            lastnumber = char
            score += 1
    if score == 1:
        number = str(number) + str(number)
    else:
        number = str(number) + str(lastnumber)
    scorefinal += int(number)

print("Part2 : " + str(scorefinal))

