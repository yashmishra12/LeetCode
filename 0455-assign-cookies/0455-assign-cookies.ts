function findContentChildren(g: number[], s: number[]): number {
    if (s.length == 0) {
        return 0;
    }
    g.sort((a,b)=>a-b);
    s.sort((a,b)=>a-b);

    let totalSatisfiedChildren = 0;

    let gIndex = 0;
    let sIndex = 0;

    while (gIndex < g.length && sIndex < s.length) {
        const greed = g[gIndex];
        const size = s[sIndex];
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