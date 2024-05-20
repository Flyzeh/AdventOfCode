f = open(r'C:\Users\giani\OneDrive\Bureau\AdventOfCode2023\input3.txt')
lines = f.read().splitlines()
f.close()

z = 0

######################### PART 1 #########################

scorefinal = 0
for line in lines:
    z += 1
    jeu = True
    ancien = ""
    for j in range(len(line)):
            k = 0
            if line[j] == " ":
                ancien = ""
            if line[j].isdigit() and line[j] != ancien:
                k = j
                if line[j+1].isdigit():
                    score_couleur = int(str(line[j]) + str(line[j+1]))
                    k += 3
                    ancien = str(line[j+1])
                else:
                    score_couleur = int(line[j])
                    k += 2
                if line[k] == "g":
                    if score_couleur > 13:
                        jeu = False
                        break
                elif line[k] == "b":
                    if score_couleur > 14:
                        jeu = False
                        break
                elif line[k] == "r":
                    if score_couleur > 12:
                        jeu = False
                        break
    if jeu == True:
        scorefinal += z
print("Part1 : " + str(scorefinal))

######################### PART 2 #########################

scorefinal2 = 0
for line in lines:
    z += 1
    ancien = ""
    tab_couleur = [0] * 3
    maxg = 0
    maxr = 0
    maxb = 0
    for j in range(len(line)):
            k = 0
            if line[j] == " ":
                ancien = ""
            if line[j].isdigit() and line[j] != ancien:
                k = j
                if line[j+1].isdigit():
                    score_couleur = int(str(line[j]) + str(line[j+1]))
                    k += 3
                    ancien = str(line[j+1])
                else:
                    score_couleur = int(line[j])
                    k += 2
                if line[k] == "g":
                    if score_couleur > maxg:
                        maxg = score_couleur
                        tab_couleur[0] = maxg
                elif line[k] == "b":
                    if score_couleur > maxb:
                        maxb = score_couleur
                        tab_couleur[1] = maxb
                elif line[k] == "r":
                    if score_couleur > maxr:
                        maxr = score_couleur
                        tab_couleur[2] = maxr
    scorefinal2 += tab_couleur[0] * tab_couleur[1] * tab_couleur[2]
print("Part2 : " + str(scorefinal2))
