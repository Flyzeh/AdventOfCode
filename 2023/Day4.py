f = open(r'your file')
lines = f.read().splitlines()
f.close()

######################### PART 1 #########################

scorefinal = 0
for line in lines:
    premier = line.split(":")
    cards = premier[1].split("|")
    number = ""
    tabcardsg = []
    tabcardsp = []
    for i in range(len(cards[0])):
        if cards[0][i].isdigit():
            number += str(cards[0][i])
        else:
            if number.isdigit():
                tabcardsg.append(number)
            number = ""
    for i in range(len(cards[1])):
        if cards[1][i].isdigit():
            number += str(cards[1][i])
            if i == len(cards[1]) - 1:
                tabcardsp.append(number)
        else:
            if number.isdigit():
                tabcardsp.append(number)
            number = ""
    score = 0
    for i in range(len(tabcardsg)):
        for j in range(len(tabcardsp)):
                if tabcardsg[i] == tabcardsp[j]:
                    if score == 0:
                        score += 1
                    else:
                        score *= 2
    scorefinal += score
print("Part1 : " + str(scorefinal))

######################### PART 2 #########################

scorefinal = 0
indice = -1
tabcopy = [0] * len(lines)
for line in lines:
    indice += 1
    premier = line.split(":")
    cards = premier[1].split("|")
    number = ""
    tabcardsg = []
    tabcardsp = []
    for i in range(len(cards[0])):
        if cards[0][i].isdigit():
            number += str(cards[0][i])
        else:
            if number.isdigit():
                tabcardsg.append(number)
            number = ""
    for i in range(len(cards[1])):
        if cards[1][i].isdigit():
            number += str(cards[1][i])
            if i == len(cards[1]) - 1:
                tabcardsp.append(number)
        else:
            if number.isdigit():
                tabcardsp.append(number)
            number = ""
    score = 0
    for i in range(len(tabcardsg)):
        for j in range(len(tabcardsp)):
                if tabcardsg[i] == tabcardsp[j]:
                        score += 1
    for k in range(score):
        tabcopy[indice+k] += 1
    scorefinal += 1
    while tabcopy[indice-1] > 0:
        for k in range(score):
            tabcopy[indice + k] += 1
        scorefinal += 1
        tabcopy[indice-1] -= 1
print("Part2 : " + str(scorefinal))

