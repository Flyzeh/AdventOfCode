import re

f = open(r'your file')
lines = f.read().splitlines()
f.close()



instruction = []
for i in lines[0]:
    instruction.append(i)

relations = {}
for line in lines[2:]:
    chemin = line.split(" =")
    chemin[1] = re.sub(r'[() ]', '', chemin[1])
    routes = chemin[1].split(",")
    relations[chemin[0]] = routes


current_key = "AAA"
i = 0
indice = 0

while current_key != "ZZZ":
    indice += 1
    next_keys = list(relations.get(current_key))
    count = len(next_keys)

    if count == 1:
        current_key = next_keys[0]
    else:
        if instruction[i] == "R":
            current_key = next_keys[1]
        else:
            current_key = next_keys[0]
    i += 1
    if i >= len(instruction):
        i = 0
print(indice)
print(current_key)

