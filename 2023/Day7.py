f = open(r'your file')
lines = f.read().splitlines()
f.close()

######################### PART 1 #########################

cards = [line.split() for line in lines]
for card in cards:
    card[0] = ['AKQJT98765432'.index(c) + 1 for c in card[0]]
print(cards)

def score(hand):
    compteur = {}
    for caractere in hand:
        if caractere in compteur:
            compteur[caractere] += 1
        else:
            compteur[caractere] = 1

    if max(compteur.values()) == 1:
        points = 1
    elif max(compteur.values()) == 3:
        if min(compteur.values()) == 2:
            points = 5
        else:
            points = 4
    elif max(compteur.values()) == 4:
        points = 6
    elif max(compteur.values()) == 5:
        points = 7
    elif max(compteur.values()) == 2:
        max_compteur = max(compteur.values())
        caracteres_max = []
        for caractere, occurences in compteur.items():
            if occurences == max_compteur:
                caracteres_max.append(caractere)
        if len(caracteres_max) == 2:
            points = 3
        else:
            points = 2
    return points

for card in cards:
    card.append(score(card[0]))

cards.sort(key=lambda x: x[2])

score_cards = {}
for card in cards:
    score = card[2]
    if score not in score_cards:
        score_cards[score] = []
    score_cards[score].append(card)
print(score_cards)

all_cards = []
for i in score_cards.values():
    i.sort(key=lambda x: x[0], reverse=True)
    all_cards.extend(i)
print(all_cards)

total = sum(int(card[1]) * (i+1) for i, card in enumerate(all_cards))

print('Part1 : ' + str(total))

