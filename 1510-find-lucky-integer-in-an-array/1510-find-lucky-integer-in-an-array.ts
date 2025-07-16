function findLucky(arr: number[]): number {
    arr.sort((a, b) => a - b)

    let freq = 1;

    for (let i = arr.length - 1; i >= 0; i--) {
        freq = 1;
        const current = arr[i];
        if(current==1) {

        }
        while (arr[i] == arr[i - 1]) {
            freq++
            i--;
        }
        if (freq == current) {
            return current;
        }
    }

    return -1;
};