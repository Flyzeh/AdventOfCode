f = open(r'your file')
lines = f.read().splitlines()
f.close()

######################### PART 1 #########################

tab = []
for line in lines:
    if line == "":
        line = " "
    tab.append(line)
print(tab)

seeds = []
premier = lines[0].split(":")
seed = premier[1].split()
for i in range(len(seed)):
    seeds.append(seed[i])
print(seeds)

tabfinal = []
for k in range(len(seeds)):
    goodseed = seed[k]
    for j in range(2, len(tab)):
        if tab[j][0].isalpha():
            j += 1
            trouve = False
            while tab[j][0].isdigit() and j < len(tab) - 1 and not trouve:
                number = tab[j].split()
                if int(number[1]) <= int(goodseed) < int(number[1]) + int(number[2]):
                    ajout = 0
                    ajout = str(int(goodseed) - int(number[1]))
                    number[1] = str(int(number[1]) + int(ajout))
                    number[0] = str(int(number[0]) + int(ajout))
                    if number[1] == goodseed:
                        goodseed = number[0]
                        trouve = True
                        break
                j += 1
    tabfinal.append(int(goodseed))
print("Part1 : " + str(min(tabfinal)))

