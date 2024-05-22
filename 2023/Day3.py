f = open(r'your file')
lines = f.read().splitlines()
f.close()

tab = []
for line in lines:
    tab.append(list(line))
print(tab)
score = 0

######################### PART 1 #########################

for i, line in enumerate(tab):
    deplacement = [(1, 1), (0, -1), (0, 1), (1, 0), (-1, -1), (-1, 0), (-1, 1), (1, -1)]
    ajout = False
    ancien = ""
    for k, j in enumerate(line):
        if not ancien.isdigit():
            if ajout:
                score += int(number)
            number = ""
            ajout = False
        if j.isdigit():
            number += str(j)
            for dli, dlc in deplacement:
                nouvelle_ligne = i + dli
                nouvelle_colonne = k + dlc
                if 0 <= nouvelle_ligne < len(tab) and 0 <= nouvelle_colonne < len(tab):
                    if tab[nouvelle_ligne][nouvelle_colonne] != '.' and not tab[nouvelle_ligne][nouvelle_colonne].isdigit():
                        ajout = True
        ancien = str(j)
    if ajout:
        score += int(number)
print("Part1 : " + str(score))

scorefinal = 0

######################### PART 2 #########################


for i, line in enumerate(tab):
    deplacement = [(1, 1), (0, -1), (0, 1), (1, 0), (-1, -1), (-1, 0), (-1, 1), (1, -1)]
    for k, j in enumerate(line):
        score = []
        number1 = ""
        if j == '*':
            visited = set()
            for dli, dlc in deplacement:
                nouvelle_ligne = i + dli
                nouvelle_colonne = k + dlc
                number = ""
                if 0 <= nouvelle_ligne < len(tab) and 0 <= nouvelle_colonne < len(tab):
                    if tab[nouvelle_ligne][nouvelle_colonne].isdigit() and (nouvelle_ligne, nouvelle_colonne) not in visited:
                        if tab[nouvelle_ligne][nouvelle_colonne - 1].isdigit():
                            if tab[nouvelle_ligne][nouvelle_colonne - 2].isdigit():
                                number += str(tab[nouvelle_ligne][nouvelle_colonne - 2])
                                visited.add((nouvelle_ligne, nouvelle_colonne-2))
                                number += str(tab[nouvelle_ligne][nouvelle_colonne - 1])
                                visited.add((nouvelle_ligne, nouvelle_colonne - 1))
                            else:
                                number += str(tab[nouvelle_ligne][nouvelle_colonne - 1])
                                visited.add((nouvelle_ligne, nouvelle_colonne - 1))
                        number += str(tab[nouvelle_ligne][nouvelle_colonne])
                        if (tab[nouvelle_ligne][nouvelle_colonne + 1]).isdigit():
                            number += str(tab[nouvelle_ligne][nouvelle_colonne + 1])
                            visited.add((nouvelle_ligne, nouvelle_colonne+1))
                            if (tab[nouvelle_ligne][nouvelle_colonne + 2]).isdigit():
                                number += str(tab[nouvelle_ligne][nouvelle_colonne + 2])
                                visited.add((nouvelle_ligne, nouvelle_colonne+2))
                        score.append(int(number))
            print(score)
            if len(score) == 2:
                scorefinal += score[0] * score[1]

print("Part2 : " + str(scorefinal))
