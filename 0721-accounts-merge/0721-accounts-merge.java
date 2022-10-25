class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        
        Map<String, Integer> emailHM = new HashMap<>();
        for(int i=0; i<accounts.size();i++){
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            
            for(String email: emails) {
                if(!emailHM.containsKey(email)) {
                    emailHM.put(email, i);
                }
                else {
                    int prevAcc = emailHM.get(email);
                    uf.union(prevAcc, i);
                }
            }
        }
        
        // go through each account and find the UF root and merge
		Map<Integer, Account> rootAccounts = new HashMap<>();
		for (int accId = 0; accId < accounts.size(); accId++) {
			List<String> account = accounts.get(accId);

			int rootAccId = uf.getAbsoluteParent(accId);
			if (!rootAccounts.containsKey(rootAccId)) {
				String rootAccName = accounts.get(rootAccId).get(0);
				rootAccounts.put(rootAccId, new Account(rootAccName));
			}
			List<String> emails =  account.subList(1, account.size());
			rootAccounts.get(rootAccId).emails.addAll(emails);
		}

		return rootAccounts.values().stream()
						.map(acc -> acc.toStringList())
						.collect(Collectors.toList());
        
    }
    
    static class UnionFind {
		int[] parent;
		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) parent[i] = i;
		}

		private void union(int x, int y) {
			int pX = getAbsoluteParent(x);
			int pY = getAbsoluteParent(y);
			if(pX!=pY){
				parent[pX] = pY;
			}
		}

		private int getAbsoluteParent(int i){
			if(parent[i]==i){
				// absolute parent
				return i;
			}
			parent[i]=getAbsoluteParent(parent[i]);
			return parent[i];
		}
	}

	static class Account {
		String name;
		Set<String> emails = new TreeSet<>();

		Account(String name) {
			this.name = name;
		}

		List<String> toStringList() {
			List<String> list = new ArrayList<>();
			list.add(name);
			list.addAll(emails);
			return list;
		}
	}
}