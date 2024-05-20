f = open(r'your file')
lines = f.read().splitlines()
f.close()

######################### PART 1 #########################

tab_temps = []
tab_distance = []
for i in range(2):
    division = lines[i].split(":")
    number = division[1].split()
    for k in range(len(number)):
        if i == 0:
            tab_temps.append(int(number[k]))
        else:
            tab_distance.append(int(number[k]))
scorefinal = 1
for j in range(len(tab_temps)):
    win = 0
    for k in range(tab_temps[j]):
        temps_restants = tab_temps[j] - k
        if k * temps_restants > tab_distance[j]:
            win += 1
    scorefinal *= win
print("Part1 : " + str(scorefinal))

######################### PART 2 #########################

tab_number = []
for line in lines:
    division = line.split(":")
    number = division[1].replace(" ", "")
    tab_number.append(int(number))
print(tab_number)

win = 0
for k in range(tab_number[0]):
    temps_restants = tab_number[0] - k
    if k * temps_restants > tab_number[1]:
        win += 1
print("Part2 : " + str(win))
