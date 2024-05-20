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

######################### PART 2 (Not Work) #########################

for i, line in enumerate(tab):
    deplacement = [(1, 1), (0, -1), (0, 1), (1, 0), (-1, -1), (-1, 0), (-1, 1), (1, -1)]
    for k, j in enumerate(line):
        score = 0
        number1 = ""
        if j == '*':
            for dli, dlc in deplacement:
                nouvelle_ligne = i + dli
                nouvelle_colonne = k + dlc
                number = ""
                if 0 <= nouvelle_ligne < len(tab) and 0 <= nouvelle_colonne < len(tab):
                    if tab[nouvelle_ligne][nouvelle_colonne].isdigit():
                        if tab[nouvelle_ligne][nouvelle_colonne - 2].isdigit():
                            number += str(tab[nouvelle_ligne][nouvelle_colonne-2])
                        if tab[nouvelle_ligne][nouvelle_colonne - 1].isdigit():
                            number += str(tab[nouvelle_ligne][nouvelle_colonne - 1])
                        number += str(tab[nouvelle_ligne][nouvelle_colonne])
                        if (tab[nouvelle_ligne][nouvelle_colonne + 1]).isdigit():
                            number += str(tab[nouvelle_ligne][nouvelle_colonne + 1])
                        if (tab[nouvelle_ligne][nouvelle_colonne + 2]).isdigit():
                            number += str(tab[nouvelle_ligne][nouvelle_colonne + 2])
                        if number != number1:
                            score += 1
                            if score == 1:
                                number1 = number
                        print(number)
            if score == 2:
                scorefinal += number * number1


print("Part2 : " + str(scorefinal))
