function matchPlayersAndTrainers(players: number[], trainers: number[]): number {

    players.sort((a,b)=>a-b);
    trainers.sort((a,b)=>a-b);

    let totalSatisfiedChildren = 0;

    let gIndex = 0;
    let sIndex = 0;

    while (gIndex < players.length && sIndex < trainers.length) {
        const greed = players[gIndex];
        const size = trainers[sIndex];
        if (size >= greed) {
            totalSatisfiedChildren++;
            gIndex++;
            sIndex++;
        } else {
            sIndex++;
        }
    }
    return totalSatisfiedChildren;
};